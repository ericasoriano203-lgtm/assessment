import { CallForwardNoReply } from "./callforwardnoreply";

export class Features {
    callForwardNoReply: CallForwardNoReply;

    constructor() {
    this.callForwardNoReply = new CallForwardNoReply();
  }
}
