import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";

@Injectable({
    providedIn: 'root',
})
export class userInfo {
    private user_id_source = new BehaviorSubject<number>(0);
    user_id = this.user_id_source.asObservable();

    updateUserID(new_id: number) {
        this.user_id_source.next(new_id);
    }

    getUserId() {
        return this.user_id_source;
    }
}