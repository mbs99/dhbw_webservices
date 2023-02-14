<?php

declare(strict_types=1);

namespace App\Domain\Product;

interface ProductRepository
{
    /**
     * @return Product[]
     */
    public function findAll(): array;

    /**
     * @param string $query
     * @return Product[]
     */
    public function findByTitleOrDescription(string $query): array;
}
