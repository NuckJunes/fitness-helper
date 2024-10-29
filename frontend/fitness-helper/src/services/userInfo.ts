import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";

@Injectable({
    providedIn: 'root',
})
export class userInfo {
    private userID = new BehaviorSubject<number>(0);
    user_id = this.userID.asObservable();
}