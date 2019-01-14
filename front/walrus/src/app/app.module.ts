import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// COMPONENTS
import { AdminQuizComponent } from './admin-quiz/admin-quiz.component';
import { HomeComponent } from './home/home.component';
import { CreateComponentDialogComponent } from './dialogs/create-component-dialog/create-component-dialog.component';
import { JoinComponentDialogComponent } from './dialogs/join-component-dialog/join-component-dialog.component';

// Form
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';

// MATERIAL
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatDialogModule} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatTableModule} from '@angular/material/table';
import {MatToolbarModule} from '@angular/material/toolbar';

// HTTP
import { HttpClientModule } from '@angular/common/http';
import { AddDialogComponent } from './admin-quiz/dialogs/add-dialog/add-dialog.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateComponentDialogComponent,
    JoinComponentDialogComponent,
    AdminQuizComponent,
    HomeComponent,
    AddDialogComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    // MATERIAL
    MatButtonModule,
    MatIconModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatToolbarModule

  ],
  entryComponents: [
    CreateComponentDialogComponent,
    JoinComponentDialogComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
