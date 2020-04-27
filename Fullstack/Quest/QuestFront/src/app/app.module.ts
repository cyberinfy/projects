import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { CategoryComponent } from './category/category.component';
import { LoginComponent } from './login/login.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { AccessComponent } from './access/access.component';
import { AskComponent } from './ask/ask.component';
import { HomeComponent } from './home/home.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { UsernavbarComponent } from './usernavbar/usernavbar.component';
import { SearchComponent } from './search/search.component';
import { QuestionviewComponent } from './questionview/questionview.component';
import { AdminnavbarComponent } from './adminnavbar/adminnavbar.component';
import { AddadminComponent } from './addadmin/addadmin.component';
import { AdduserComponent } from './adduser/adduser.component';
import { AdminsearchComponent } from './adminsearch/adminsearch.component';
import { LoginserviceService } from './login/loginservice.service';
import { ChangepasswordService } from './changepassword/changepassword.service';
import { AddadminService } from './addadmin/addadmin.service';
import { CategoryService } from './category/category.service';
import { AccessService } from './access/access.service';
import { FilterdataPipe } from './search/filterdata.pipe';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AdminComponent,
    UserComponent,
    CategoryComponent,
    LoginComponent,
    ChangepasswordComponent,
    AccessComponent,
    AskComponent,
    HomeComponent,
    FeedbackComponent,
    UsernavbarComponent,
    SearchComponent,
    QuestionviewComponent,
    AdminnavbarComponent,
    AddadminComponent,
    AdduserComponent,
    AdminsearchComponent,
    FilterdataPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [LoginserviceService, ChangepasswordService, AddadminService, CategoryService, AccessService],
  bootstrap: [AppComponent]
})
export class AppModule { }
