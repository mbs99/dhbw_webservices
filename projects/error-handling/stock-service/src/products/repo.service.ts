import { Injectable } from '@nestjs/common';
import { TypeOrmOptionsFactory, TypeOrmModuleOptions, InjectRepository } from '@nestjs/typeorm';
import { ConfigService } from '@nestjs/config';
import { Events } from './db/events';
import { Repository } from 'typeorm';

@Injectable()
export class RepoService {
  constructor(
    @InjectRepository(Events)
    private eventsRepository: Repository<Events>,
  ) {}

  findEventsByProductId(id: string): Promise<Events[]> {
    return this.eventsRepository.find(
      {
        where: {
        productId: id,
        },
        order: {
          timestamp: {
            direction: 'asc'
          }
        }
      })
  }

  undoEvent(id: number) {
    return this.eventsRepository.delete({id:id});
  }

  addEvent(event: Events) {
    return this.eventsRepository.save(event);
  }
}