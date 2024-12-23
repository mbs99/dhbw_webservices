import { Controller, Get } from '@nestjs/common';
import { AppService } from './app.service';
import { Note } from './notes/note';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get('/api/notes')
  getNotes(): Promise<Note[]> {
    return this.appService.getNotes();
  }
}
