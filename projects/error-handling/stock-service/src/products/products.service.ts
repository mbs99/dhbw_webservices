import { Injectable } from '@nestjs/common';
import { Events } from './db/events';
import { ProductDto } from './dto/product.dto';
import { RepoService } from './repo.service';

@Injectable()
export class ProductsService {
    constructor(private readonly repoService: RepoService) {}

    getStockByProductId(id: string): Promise<number> {
        return this.repoService.findEventsByProductId(id)
        .then(events => events.map(event => event.stock)
        .reduce((l,r) => l+r))
    }

    updateStockByProductId(product: ProductDto): Promise<number> {
        const event: Events = new Events();
        event.productId = product.getProductId();
        event.stock = product.getStock();
        event.timestamp = Date.now();
    
        return this.repoService.addEvent(event).then(res => res.id);
    }

    undo(eventId: number) {
       return this.repoService.undoEvent(eventId);
    }
}

