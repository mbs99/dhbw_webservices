import { Module } from '@nestjs/common';
import { ProductsService } from './products.service';
import { ProductsController } from './products.controller';
import { RepoService } from './repo.service';
import { Events } from './db/events';
import { TypeOrmModule } from '@nestjs/typeorm';

@Module({
  imports: [TypeOrmModule.forFeature([Events])],
  controllers: [ProductsController],
  providers: [ProductsService, RepoService]
})
export class ProductsModule {}
