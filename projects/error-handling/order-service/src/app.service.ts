import { HttpService } from '@nestjs/axios';
import { Injectable } from '@nestjs/common';
import { AxiosError } from 'axios';
import { catchError, firstValueFrom } from 'rxjs';
import { OrderDto } from './order.dto';

interface Dto {
  productId: string,
  stock: number
}

@Injectable()
export class AppService {

  stockUrl = "localhost:3000";
  paymentUrl = "localhost:3001"

  constructor(private readonly httpService: HttpService) {}

  async submitOrder(orderDto: OrderDto): Promise<void> {
   
    const body: Dto[] = orderDto.items.map(item => {
      const dto: Dto = {
        productId: item.id,
        stock: item.count
      }
      return dto;
    })

    let response;

    // proccess only first result

    try {
      response = await firstValueFrom(this.httpService.post(`http://${this.stockUrl}/api/products/${body[0].productId}`, body[0]));
      console.log(response.data)

      await firstValueFrom(this.httpService.post(`http://${this.paymentUrl}/api/payment?force-error=true`, body[0]));
      console.log(response.data)
    }
    catch(e) {
      console.log(e);

      if((e as AxiosError).response.status === 500) {
        response = await firstValueFrom(this.httpService.delete(`http://${this.stockUrl}/api/products/events/${response.data}`));
        console.log(response.data)
      } else {
        throw e;
      }
    }

  }
  getHello(): string {
    return 'Hello World!';
  }

}
