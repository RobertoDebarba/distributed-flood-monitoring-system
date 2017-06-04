import {Router, Request, Response} from "express";

export class SampleRouter {

    router:Router;

    constructor() {
        this.router = Router();
        this.init();
    }

    public init() {
        this.router.get('/', this.getSample);
    }

    private getSample(request:Request, response:Response) {
        response.send("Sample Route");
    }

}

const sampleRouter = new SampleRouter();
sampleRouter.init();

export default sampleRouter.router;
