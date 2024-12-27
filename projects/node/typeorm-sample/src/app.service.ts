import { Injectable } from '@nestjs/common';
import { NotesService } from './notes/notes.service';
import { Note } from './notes/note';

@Injectable()
export class AppService {
  constructor(private readonly notesService: NotesService) {}

  async getHtmlNoteList(): Promise<string> {
    const notes = await this.notesService.getAllNotes();
    return this.createHtmlNoteList(notes);
  }

  async addNote(note: Note) {
    if (note.text?.length) {
      await this.notesService.addNote(note);
    }
    return this.getHtmlNoteList();
  }

  async search(query: string) {
    if (query.length) {
      const notes = await this.notesService.findNotesByTextContaining(query);
      return this.createHtmlNoteList(notes);
    }
    return this.getHtmlNoteList();
  }

  private createHtmlNoteList(notes: Note[]) {
    const listItems = notes.reduce((l, r) => {
      return `${l}<li>${r.text}</li>`;
    }, '');
    return listItems.length
      ? `<h3>Notes</h3><ul>${listItems}</ul>`
      : '<p>Please add some notes first.</p>';
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
