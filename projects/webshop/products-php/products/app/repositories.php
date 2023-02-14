<?php

declare(strict_types=1);

use App\Domain\Product\ProductRepository;
use App\Infrastructure\Persistence\Product\InMemoryProductRepository;
use DI\ContainerBuilder;

return function (ContainerBuilder $containerBuilder) {
    // Here we map our UserRepository interface to its in memory implementation
    $containerBuilder->addDefinitions([
        ProductRepository::class => \DI\autowire(InMemoryProductRepository::class),
    ]);
};
