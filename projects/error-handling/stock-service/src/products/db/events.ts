import { Column, Entity, PrimaryGeneratedColumn } from "typeorm";

@Entity({
  name: 'events'
})
export class Events {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({
    type: "varchar",
    name: "product-id"
  })
  productId: string;

  @Column({
    type: "integer",
    name: "stock"
  })
  stock: number;

  @Column({
    type: "bigint",
    name: "timestamp"
  })
  timestamp: number;
}