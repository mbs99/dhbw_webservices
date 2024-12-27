import {
  Body,
  Controller,
  Delete,
  Get,
  Param,
  Post,
  Query,
} from '@nestjs/common';
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

  @Post('/search')
  async search(@Body('query') query: string): Promise<string> {
    return this.appService.search(query);
  }

  @Delete('/delete/:id')
  async delete(@Param('id') id: string): Promise<string> {
    return this.appService.delete(id);
  }
}
