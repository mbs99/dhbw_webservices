import { OrderItemDto } from "./item.dto";

export class OrderDto {
    constructor(readonly items: OrderItemDto[]) {}
}