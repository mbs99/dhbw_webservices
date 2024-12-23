import { Column, Entity, PrimaryGeneratedColumn } from 'typeorm';

@Entity('notes')
export class NoteEntity {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ name: 'text', nullable: false })
  text: string;
}
