<?php

declare(strict_types=1);

namespace App\Application\Actions\Product;

use App\Application\Actions\Action;
use App\Domain\Product\ProductRepository;
use Psr\Log\LoggerInterface;

abstract class ProductAction extends Action
{
    protected ProductRepository $productRepository;

    public function __construct(LoggerInterface $logger, ProductRepository $productRepository)
    {
        parent::__construct($logger);
        $this->productRepository = $productRepository;
    }
}
