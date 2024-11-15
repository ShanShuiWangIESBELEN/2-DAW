import { Component } from '@angular/core';
import {EmpresaService} from "../../../../service/empresa.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-crear',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgIf
  ],
  template: `
    <body>
    <div class="form-container">
      <form [formGroup]="form" (ngSubmit)="onSubmit()" class="form-column">
        <!-- Columna izquierda -->
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" formControlName="nombre">
        <div *ngIf="form.get('nombre')?.hasError('required')">Este campo es obligatorio.</div>
        <div *ngIf="form.get('nombre')?.hasError('pattern')">El nombre solo puede contener letras, números, espacios, comillas simples y comillas dobles.</div>
        <div *ngIf="form.get('nombre')?.hasError('maxlength')">El nombre no puede exceder los 100 caracteres.</div>

        <!-- Dirección -->
        <label for="direccion">Dirección:</label>
        <input type="text" id="direccion" formControlName="direccion">
        <div *ngIf="form.get('direccion')?.hasError('required')">Este campo es obligatorio.</div>
        <div *ngIf="form.get('direccion')?.hasError('pattern')">La dirección solo puede contener letras, números, espacios, comillas simples y comillas dobles.</div>
        <div *ngIf="form.get('direccion')?.hasError('maxlength')">La dirección no puede exceder los 100 caracteres.</div>

        <!-- Teléfono -->
        <label for="telefono">Teléfono:</label>
        <input type="text" id="telefono" formControlName="telefono">
        <div *ngIf="form.get('telefono')?.hasError('required')">Este campo es obligatorio.</div>
        <div *ngIf="form.get('telefono')?.hasError('pattern')">El teléfono debe contener solo números y tener una longitud de 9 dígitos.</div>

        <!-- Email -->
        <label for="email">Email:</label>
        <input type="text" id="email" formControlName="email">
        <div *ngIf="form.get('email')?.hasError('required')">Este campo es obligatorio.</div>
        <div *ngIf="form.get('email')?.hasError('pattern')">Ingresa una dirección de correo electrónico válida.</div>
        <div *ngIf="form.get('email')?.hasError('maxlength')">El email no puede exceder los 100 caracteres.</div>

        <!-- Descripción -->
        <label for="descripcion">Descripción:</label>
        <input type="text" id="descripcion" formControlName="descripcion">
        <div *ngIf="form.get('descripcion')?.hasError('required')">Este campo es obligatorio.</div>
        <div *ngIf="form.get('descripcion')?.hasError('pattern')">La descripción solo puede contener letras, números, espacios, comillas simples y comillas dobles.</div>
        <div *ngIf="form.get('descripcion')?.hasError('maxlength')">La descripción no puede exceder los 50 caracteres.</div>
      </form>

      <!-- Columna derecha -->
      <form [formGroup]="form" (ngSubmit)="onSubmit()" class="form-column">


        <!-- Imagen -->
        <label for="imagen">Imagen:</label>
        <input type="text" id="imagen" formControlName="imagen">
        <div *ngIf="form.get('imagen')?.hasError('required')">Este campo es obligatorio.</div>
        <div *ngIf="form.get('imagen')?.hasError('maxlength')">El nombre no puede exceder los 500 caracteres.</div>

        <!-- Historia -->
        <label for="historia">Historia:</label>
        <textarea id="historia" formControlName="historia"></textarea>
        <div *ngIf="form.get('historia')?.hasError('required')">Este campo es obligatorio.</div>
        <div *ngIf="form.get('historia')?.hasError('pattern')">La historia no puede exceder las 500 palabras.</div>

        <!-- Latitud -->
        <label for="latitud">Latitud:</label>
        <input type="text" id="latitud" formControlName="latitud">
        <div *ngIf="form.get('latitud')?.hasError('required')">Este campo es obligatorio.</div>
        <div *ngIf="form.get('latitud')?.hasError('pattern')">Ingresa una latitud válida.</div>
        <div *ngIf="form.get('latitud')?.hasError('maxlength')">La latitud no puede exceder los 20 caracteres.</div>

        <!-- Longitud -->
        <label for="longitud">Longitud:</label>
        <input type="text" id="longitud" formControlName="longitud">
        <div *ngIf="form.get('longitud')?.hasError('required')">Este campo es obligatorio.</div>
        <div *ngIf="form.get('longitud')?.hasError('pattern')">Ingresa una longitud válida.</div>
        <div *ngIf="form.get('longitud')?.hasError('maxlength')">La longitud no puede exceder los 20 caracteres.</div>

        <button type="submit">Crear</button>
      </form>
    </div>
    </body>

  `,
  styleUrl: './crear.component.css'
})
export class CrearComponent {

  constructor(
    public empresaService: EmpresaService,
    public router: Router
  ) {
  }

  form: FormGroup = new FormGroup({
    nombre: new FormControl('', [Validators.required,  Validators.pattern(/^[A-Za-z0-9\s']*$/), Validators.maxLength(100),]),
    direccion: new FormControl('', [Validators.required, Validators.pattern(/^[a-zA-Z0-9\s\/.,\-']+$/), Validators.maxLength(100)]),
    telefono: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{9}')]),
    email: new FormControl('', [Validators.required, Validators.pattern(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/), Validators.maxLength(100)]),
    descripcion: new FormControl('', [Validators.required, Validators.pattern(/^[a-zA-Z0-9\s\/.,\-']+$/), Validators.maxLength(50)]),
    imagen: new FormControl('', [Validators.required, Validators.maxLength(500)]),
    historia: new FormControl('', [Validators.required, Validators.pattern(/^(\s*\S+\s*){1,500}$/)]),
    latitud: new FormControl('', [  Validators.required, Validators.pattern(/^[-+]?([1-8]?\d(\.\d+)?|90(\.0+)?)$/), Validators.maxLength(20)]),
    longitud: new FormControl('', [Validators.required, Validators.pattern(/^[-+]?(180(\.0+)?|((1[0-7]\d)|([1-9]?\d))(\.\d+)?)$/), Validators.maxLength(20)]),
  });

  onSubmit() {
      this.empresaService.create(this.form.value).subscribe(res => {
        console.log('Empresa creada correctamente!' + res.nombre);
        this.router.navigateByUrl('empresa').then();
      })
    }

}
