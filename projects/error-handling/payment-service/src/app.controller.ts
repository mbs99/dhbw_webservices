import { Controller, Get, HttpCode, HttpException, HttpStatus, Post, Query } from '@nestjs/common';
import { AppService } from './app.service';

@Controller('/api')
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get('/hello')
  getHello(): string {
    return this.appService.getHello();
  }

  @Post('/payment')
  @HttpCode(204)
  startPayment(@Query('force-error') forceError): string {
    if('true' === forceError) {
      throw new HttpException('internal error', HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return '';
  }
}
