export class ProductDto {

    constructor(private readonly productId: string, private readonly stock: number) {}

    getProductId(): string {
        return this.productId;
    }

    getStock(): number {
        return this.stock;
    }
}
