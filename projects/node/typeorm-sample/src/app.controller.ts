import { Body, Controller, Get, Post } from '@nestjs/common';
import { AppService } from './app.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get('/notes')
  async getHtmlNoteList(): Promise<string> {
    return this.appService.getHtmlNoteList();
  }

  @Post('/notes')
  async addNote(@Body('note') noteText: string): Promise<string> {
    return this.appService.addNote({ text: noteText, date: new Date() });
  }
}
