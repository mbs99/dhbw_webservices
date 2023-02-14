<?php

declare(strict_types=1);

namespace App\Infrastructure\Persistence\Product;

use App\Domain\Product\Product;
use App\Domain\Product\ProductRepository;

class InMemoryProductRepository implements ProductRepository
{
    /**
     * @var Product[]
     */
    private array $products;

    /**
     * @param Product[]|null $products
     */
    public function __construct(array $products = null)
    {
        $this->products = $products ?? [
            1 => new Product('Warpkern', 'refurbished', '1'),
            2 => new Product('Flux Compensator', 'neu', '99'),
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function findAll(): array
    {
        return array_values($this->products);
    }

    /**
     * {@inheritdoc}
     */
    public function findByTitleOrDescription(string $query): array
    {
        if(empty($query)) {
            return $this->findAll();
        }

        $result = array();

        foreach($this->products as &$product) {
            if(str_contains(strtolower($product->getTitle()), strtolower($query))
            || str_contains(strtolower($product->getDescription()), strtolower($query))) {
                array_push($result, $product);
            }
        }

        return array_values($result);
    }
}
