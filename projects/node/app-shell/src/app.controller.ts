import { Controller, Get, Res } from '@nestjs/common';
import { AppService } from './app.service';
import { Response } from 'express';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getIndex(@Res() res: Response) {
    return res.render('index', { message: 'Hello world!' });
  }

  @Get('/a')
  getContentA(@Res() res: Response) {
    return res.render('a', { message: 'Hello world from A!' });
  }

  @Get('/b')
  getContentB(@Res() res: Response) {
    return res.render('b', { message: 'Hello world from B!' });
  }
}
