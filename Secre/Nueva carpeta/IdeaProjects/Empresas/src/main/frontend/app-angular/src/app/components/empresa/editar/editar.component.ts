import {Component, OnInit} from '@angular/core';
import {Empresa} from "../../../../models/empresa";
import {EmpresaService} from "../../../../service/empresa.service";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-editar',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgIf,
    RouterLink
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

      <form [formGroup]="form" (ngSubmit)="onSubmit()" class="form-column">
        <!-- Columna derecha -->
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

        <button type="submit">Cambiar</button>
      </form>
    </div>
    </body>
  `,
  styleUrl: './editar.component.css'
})
export class EditarComponent implements OnInit{
  id: number = 0;
  empresa: Empresa = {id: 0, nombre: "", direccion: "", telefono: 0, email: "", descripcion: "", imagen: "", historia: "",latitud: 0, longitud: 0};


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

  constructor(
    public empresaService: EmpresaService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.empresaService.find(this.id).subscribe((data: Empresa) => {
      this.empresa = data;
      this.form.get('nombre')?.setValue(this.empresa.nombre);
      this.form.get('direccion')?.setValue(this.empresa.direccion);
      this.form.get('telefono')?.setValue(this.empresa.telefono);
      this.form.get('email')?.setValue(this.empresa.email);
      this.form.get('descripcion')?.setValue(this.empresa.descripcion);
      this.form.get('imagen')?.setValue(this.empresa.imagen);
      this.form.get('historia')?.setValue(this.empresa.historia);
      this.form.get('latitud')?.setValue(this.empresa.latitud);
      this.form.get('longitud')?.setValue(this.empresa.longitud);
    });
  }

  onSubmit(){

      const updatedEmpresa: Empresa = {
        id: this.id,
        nombre: this.form.value.nombre,
        direccion: this.form.value.direccion,
        telefono: this.form.value.telefono,
        email: this.form.value.email,
        descripcion: this.form.value.descripcion,
        imagen: this.form.value.imagen,
        historia: this.form.value.historia,
        latitud: this.form.value.latitud,
        longitud: this.form.value.longitud,
      };

      this.empresaService.update(this.empresa.id, updatedEmpresa).subscribe(res => {
        this.router.navigateByUrl('empresa').then();
      })
  }
}
