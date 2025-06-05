import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule, FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, RouterModule, ReactiveFormsModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  isPasswordVisible: boolean = false;
  isFormSubmitted: boolean = false;
  rememberMe: boolean = false;
  loginError: string | null = null;
  loading: boolean = false;
  
  constructor(private fb: FormBuilder) {}
  
  ngOnInit(): void {
    this.initForm();
  }
  
  /**
   * Initialize the login form with validators
   */
  private initForm(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }
  
  /**
   * Submit the login form
   */
  onSubmit(): void {
    this.isFormSubmitted = true;
    
    if (this.loginForm.invalid) {
      return;
    }
    
    this.loading = true;
    
    // Simulate API call
    setTimeout(() => {
      // For demo purposes, we'll just log the values
      console.log('Login form submitted:', this.loginForm.value);
      console.log('Remember me:', this.rememberMe);
      
      // Simulate successful login
      this.loading = false;
      
      // Redirect to home page after successful login
      // In a real app, this would happen after successful authentication
      // window.location.href = '/';
    }, 1500);
  }
  
  /**
   * Toggle password visibility
   */
  togglePasswordVisibility(): void {
    this.isPasswordVisible = !this.isPasswordVisible;
  }
  
  /**
   * Check if a form control is invalid and touched or form is submitted
   */
  isControlInvalid(controlName: string): boolean {
    const control = this.loginForm.get(controlName);
    return !!control && control.invalid && (control.touched || this.isFormSubmitted);
  }
  
  /**
   * Get error message for email field
   */
  getEmailErrorMessage(): string {
    const control = this.loginForm.get('email');
    if (control?.hasError('required')) {
      return 'Email is required';
    }
    if (control?.hasError('email')) {
      return 'Please enter a valid email address';
    }
    return '';
  }
  
  /**
   * Get error message for password field
   */
  getPasswordErrorMessage(): string {
    const control = this.loginForm.get('password');
    if (control?.hasError('required')) {
      return 'Password is required';
    }
    if (control?.hasError('minlength')) {
      return 'Password must be at least 6 characters';
    }
    return '';
  }
}
