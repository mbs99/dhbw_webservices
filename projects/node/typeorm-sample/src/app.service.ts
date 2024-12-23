import { Injectable } from '@nestjs/common';
import { NotesService } from './notes/notes.service';
import { Note } from './notes/note';

@Injectable()
export class AppService {
  constructor(private readonly notesService: NotesService) {}

  async getNotes(): Promise<Note[]> {
    return this.notesService.findNotesByTextContaining('test');
  }

  /*
  async addNote(): Promise<Note> {
    return this.notesService.findNotesByTextContaining('test');
  }

  async deleteNote(id: number): Promise<Note> {
    return this.notesService.findNotesByTextContaining('test');
  }

   */
}
