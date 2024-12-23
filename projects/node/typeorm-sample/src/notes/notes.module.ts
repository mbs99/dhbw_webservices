import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { NoteEntity } from './note.entity';
import { NotesService } from './notes.service';

// noinspection TypeScriptValidateTypes
@Module({
  imports: [TypeOrmModule.forFeature([NoteEntity])],
  providers: [NotesService],
  exports: [NotesService],
})
export class NotesModule {}
