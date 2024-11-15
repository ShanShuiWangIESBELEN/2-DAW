import {Component, inject, OnInit} from '@angular/core';
import * as $ from 'jquery';
import {NgForOf} from "@angular/common";
import { Task } from '../../model/task';
import {TaskService} from "../task.service";

@Component({
  selector: 'app-form-main',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './form-main.component.html',
  styleUrl: './form-main.component.css'
})
export class FormMainComponent implements OnInit {

  tasks: Task[] = [];
  taskService: TaskService = inject(TaskService);

 eliminateTask(t: Task): void {
   this.tasks.find(ta => ta === t);
 }

  eliminateAllComplete(){

  }
  create(n: string, date: string){

   const t: Task ={
     taskName: n,
     priority: "low",
     dateCreation: date ,
     dateCompletion: "",
     complete: false
   }
   this.taskService.setTask(t);

  }

  ngOnInit(): void {
   this.taskService.getTask().subscribe((task) => {
     this.tasks.push(task);
     console.log(task)
   })
  }
}
