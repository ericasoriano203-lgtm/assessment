import { Features } from "./features";

export class Subscriber {
    phoneNumber: number;
    userName: number;
    password?: string;
    domain: string;
    status: string;
    features: Features;

    constructor() {
    this.features = new Features();
  }
}
