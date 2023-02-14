<?php

declare(strict_types=1);

namespace App\Domain\Product;

use JsonSerializable;

class Product implements JsonSerializable
{
    
    private string $title;

    private string $description;

    private string $articleId;

    public function __construct(string $title, string $description, string $articleId)
    {
        $this->title = $title;
        $this->description = $description;
        $this->articleId = $articleId;
    }

    public function getTitle(): string
    {
        return $this->title;
    }

    public function getDescription(): string
    {
        return $this->description;
    }

    public function getArticleId(): string
    {
        return $this->articleId;
    }

    #[\ReturnTypeWillChange]
    public function jsonSerialize(): array
    {
        return [
            'title' => $this->title,
            'description' => $this->description,
            'articleId' => $this->articleId,
        ];
    }
}
