<?php

declare(strict_types=1);

namespace App\Application\Actions\Product;

use Psr\Http\Message\ResponseInterface as Response;

class SearchAction extends ProductAction
{
    /**
     * {@inheritdoc}
     */
    protected function action(): Response
    {
        $query = $this->resolveQueryParam('query');
        $result = $this->productRepository->findByTitleOrDescription($query);

        return $this->respondWithData($result);
    }
}
