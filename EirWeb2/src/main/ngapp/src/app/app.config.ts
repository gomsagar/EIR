import { OpaqueToken } from "@angular/core";
export let APP_CONFIG = new OpaqueToken("app.config");

export interface IAppConfig {
    apiEndpointForLocalHost: string;
    apiEndpointForUAT : string;
}

export const AppConfig: IAppConfig = {    
    apiEndpointForLocalHost: "http://localhost:8080/EirWeb2/eir/",
    apiEndpointForUAT: "" 
};