import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { CategoryComponent } from './category/category.component';
import { AskComponent } from './ask/ask.component';
import { AdminComponent } from './admin/admin.component';
import { AccessComponent } from './access/access.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { SearchComponent } from './search/search.component';
import { QuestionviewComponent } from './questionview/questionview.component';
import { AddadminComponent } from './addadmin/addadmin.component';
import { AdduserComponent } from './adduser/adduser.component';
import { AdminsearchComponent } from './adminsearch/adminsearch.component';

const routes: Routes = [
    {path: 'access', component: AccessComponent},
    {path: 'admin', component: AdminComponent},
    {path: 'ask', component: AskComponent},
    {path: 'category', component: CategoryComponent},
    {path: 'changepassword', component: ChangepasswordComponent},
    {path: 'home', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'questionview', component: QuestionviewComponent},
    {path: 'user', component: UserComponent},
    {path: 'feedback', component: FeedbackComponent},
    {path: 'search', component: SearchComponent},
    {path: 'addadmin', component: AddadminComponent},
    {path: 'adduser', component: AdduserComponent},
    {path: 'adminsearch', component: AdminsearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
