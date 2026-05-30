export type Role = "USER" | "ADMIN";

export interface RegisterRequest {
  name: string;
  email: string;
  password: string;
  role: Role;
}

export interface LoginRequest {
  email: string;
  password: string;
}

export interface AuthResponse {
  token: string;
  id: number;
  name: string;
  email: string;
  role: Role;
}