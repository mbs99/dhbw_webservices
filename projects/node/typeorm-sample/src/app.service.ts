import { Injectable } from '@nestjs/common';
import { NotesService } from './notes/notes.service';
import { Note } from './notes/note';
import Handlebars from 'handlebars';

const listTemplate = `<h3>{{title}}</h3><ul class="list-group list-group-horizontal">
  {{#each notes as | note |}}
    <li class="list-group-item">
    <div class="ms-2 me-auto">{{text}}</div>
    <a href="#" hx-trigger="click" hx-target="#note-list" hx-delete="/delete/{{note.id}}">
    <span class="badge rounded-pill text-bg-danger">Delete</span>
    </a>
    </li>{{else}}
    <p>{{placeholder}}</p>
{{/each}}</ul>`;

@Injectable()
export class AppService {
  private readonly template;
  constructor(private readonly notesService: NotesService) {
    this.template = Handlebars.compile(listTemplate);
  }

  async getHtmlNoteList(): Promise<string> {
    const notes = await this.notesService.getAllNotes();
    return this.createHtmlNoteList(notes, 'Add some notes first');
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
      return this.createHtmlNoteList(notes, 'No match');
    }
    return this.getHtmlNoteList();
  }

  private createHtmlNoteList(notes: Note[], placeholder: string) {
    return this.template({
      title: 'Notes',
      notes,
      placeholder,
    });
  }

  async delete(id: string) {
    if (id.length) {
      await this.notesService.deleteById(id);
      const notes = await this.notesService.getAllNotes();
      return this.createHtmlNoteList(notes, 'No match');
    }
    return this.getHtmlNoteList();
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
