import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Task} from "../model/task";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  taskSubject = new BehaviorSubject<Task>(JSON.parse(localStorage.getItem('task')!));

  getTask(): Observable<Task>{
    return this.taskSubject.asObservable();
  }

  setTask(task: Task): void{
    if (task){
      localStorage.setItem('task', JSON.stringify(task));
    }
    this.taskSubject.next(task);
  }
}
