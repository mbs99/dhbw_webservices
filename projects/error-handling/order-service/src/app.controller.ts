import { Body, Controller, Get, Param, Post } from '@nestjs/common';
import { AppService } from './app.service';
import { OrderDto } from './order.dto';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getHello(): string {
    return this.appService.getHello();
  }

  @Post('api/order')
  submitOrder(@Param() params, @Body() orderDto: OrderDto) {
    return this.appService.submitOrder(orderDto);
  }
}
