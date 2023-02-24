import { Body, ClassSerializerInterceptor, Controller, Delete, Get, Param, Post, UseInterceptors } from '@nestjs/common';
import { plainToClass, plainToInstance } from 'class-transformer';
import { ProductDto } from './dto/product.dto';
import { ProductsService } from './products.service';

@Controller('/api/products')
@UseInterceptors(ClassSerializerInterceptor)
export class ProductsController {
  constructor(private readonly productsService: ProductsService) {}

  @Get(':id/stock')
  getStock(@Param() params): Promise<number> {
    return this.productsService.getStockByProductId(params.id);
  }

  @Post(':id')
  updateStock(@Param() params, @Body() productDto: ProductDto) {
    return this.productsService.updateStockByProductId(plainToInstance(ProductDto, productDto));
  }

  @Delete('events/:id')
  undo(@Param() params) {
    return this.productsService.undo(params.id);
  }
}
