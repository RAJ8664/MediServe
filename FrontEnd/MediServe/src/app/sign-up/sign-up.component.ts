import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule, FormsModule } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [CommonModule, RouterModule, ReactiveFormsModule, FormsModule],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent implements OnInit {
  signUpForm!: FormGroup;
  isPasswordVisible: boolean = false;
  isConfirmPasswordVisible: boolean = false;
  isFormSubmitted: boolean = false;
  agreeToTerms: boolean = false;
  signUpError: string | null = null;
  loading: boolean = false;
  
  constructor(private fb: FormBuilder) {}
  
  ngOnInit(): void {
    this.initForm();
  }
  
  /**
   * Initialize the sign up form with validators
   */
  private initForm(): void {
    this.signUpForm = this.fb.group({
      fullName: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern(/^[0-9]{10}$/)]],
      password: ['', [Validators.required, Validators.minLength(8), 
        Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/)]],
      confirmPassword: ['', [Validators.required]]
    }, { 
      validators: this.passwordMatchValidator 
    });
  }
  
  /**
   * Custom validator to check if password and confirm password match
   */
  private passwordMatchValidator(form: FormGroup) {
    const password = form.get('password')?.value;
    const confirmPassword = form.get('confirmPassword')?.value;
    
    if (password !== confirmPassword) {
      form.get('confirmPassword')?.setErrors({ mismatch: true });
      return { mismatch: true };
    }
    
    return null;
  }
  
  /**
   * Submit the sign up form
   */
  onSubmit(): void {
    this.isFormSubmitted = true;
    
    if (this.signUpForm.invalid || !this.agreeToTerms) {
      return;
    }
    
    this.loading = true;
    
    // Simulate API call
    setTimeout(() => {
      // For demo purposes, we'll just log the values
      console.log('Sign up form submitted:', this.signUpForm.value);
      console.log('Agree to terms:', this.agreeToTerms);
      
      // Simulate successful registration
      this.loading = false;
      
      // Redirect to home page after successful registration
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
   * Toggle confirm password visibility
   */
  toggleConfirmPasswordVisibility(): void {
    this.isConfirmPasswordVisible = !this.isConfirmPasswordVisible;
  }
  
  /**
   * Check if a form control is invalid and touched or form is submitted
   */
  isControlInvalid(controlName: string): boolean {
    const control = this.signUpForm.get(controlName);
    return !!control && control.invalid && (control.touched || this.isFormSubmitted);
  }
  
  /**
   * Get error message for full name field
   */
  getFullNameErrorMessage(): string {
    const control = this.signUpForm.get('fullName');
    if (control?.hasError('required')) {
      return 'Full name is required';
    }
    if (control?.hasError('minlength')) {
      return 'Full name must be at least 3 characters';
    }
    return '';
  }
  
  /**
   * Get error message for email field
   */
  getEmailErrorMessage(): string {
    const control = this.signUpForm.get('email');
    if (control?.hasError('required')) {
      return 'Email is required';
    }
    if (control?.hasError('email')) {
      return 'Please enter a valid email address';
    }
    return '';
  }
  
  /**
   * Get error message for phone field
   */
  getPhoneErrorMessage(): string {
    const control = this.signUpForm.get('phone');
    if (control?.hasError('required')) {
      return 'Phone number is required';
    }
    if (control?.hasError('pattern')) {
      return 'Please enter a valid 10-digit phone number';
    }
    return '';
  }
  
  /**
   * Get error message for password field
   */
  getPasswordErrorMessage(): string {
    const control = this.signUpForm.get('password');
    if (control?.hasError('required')) {
      return 'Password is required';
    }
    if (control?.hasError('minlength')) {
      return 'Password must be at least 8 characters';
    }
    if (control?.hasError('pattern')) {
      return 'Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character';
    }
    return '';
  }
  
  /**
   * Get error message for confirm password field
   */
  getConfirmPasswordErrorMessage(): string {
    const control = this.signUpForm.get('confirmPassword');
    if (control?.hasError('required')) {
      return 'Please confirm your password';
    }
    if (control?.hasError('mismatch')) {
      return 'Passwords do not match';
    }
    return '';
  }
}
