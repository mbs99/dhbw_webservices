import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { TypeOrmModule } from '@nestjs/typeorm';
import { NotesModule } from './notes/notes.module';
import { NoteEntity } from './notes/note.entity';
import * as path from 'path';
import { join } from 'path';
import { ServeStaticModule } from '@nestjs/serve-static';

// noinspection TypeScriptValidateTypes
@Module({
  imports: [
    ServeStaticModule.forRoot({
      rootPath: join(__dirname, '..', 'assets'),
    }),
    TypeOrmModule.forRoot({
      type: 'sqlite',
      database: path.resolve(__dirname, '../db/db.sqlite'),
      entities: [NoteEntity],
      synchronize: true,
    }),
    NotesModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
