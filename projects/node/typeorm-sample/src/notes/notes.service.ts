import { Injectable } from '@nestjs/common';
import { NoteEntity } from './note.entity';
import { Repository } from 'typeorm';
import { InjectRepository } from '@nestjs/typeorm';
import { Note } from './note';

// noinspection TypeScriptValidateTypes
@Injectable()
export class NotesService {
  constructor(
    @InjectRepository(NoteEntity)
    private notesRepository: Repository<NoteEntity>,
  ) {}

  public addNote(note: Note) {
    const entity = new NoteEntity();
    entity.text = note.text;
    return this.notesRepository.save(entity);
  }

  public async getAllNotes() {
    return this.notesRepository.find();
  }

  public async findNotesByTextContaining(text: string) {
    const results = await this.notesRepository
      .createQueryBuilder('note')
      .where('note.text like :text', { text: `%${text}%` })
      .getMany();

    return results.map(
      (entity) =>
        ({
          id: entity.id,
          text: entity.text,
        }) as Note,
    );
  }

  public async deleteById(id: string) {
    await this.notesRepository
      .createQueryBuilder('note')
      .delete()
      .where('id = :id', { id: id })
      .execute();
  }
}
