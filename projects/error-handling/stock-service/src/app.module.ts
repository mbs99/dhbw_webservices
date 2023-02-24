import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { config } from './config/config';
import { ProductsModule } from './products/products.module';
import { RepoService } from './products/repo.service';
import { DbService } from './db/db.service';

@Module({
  imports: [ProductsModule, ConfigModule.forRoot({
    load: [config],
  }),
  TypeOrmModule.forRootAsync({
    imports: [ConfigModule],
    useClass: DbService
  }),],
  controllers: [AppController],
  providers: [AppService, DbService],
})
export class AppModule {}
