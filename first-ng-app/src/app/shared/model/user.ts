export interface User {
  id: string;

  username: string;

  password: string;

  name: string;

  gender: number;

  isAdmin: boolean;

  birthday: number;

  phoneNum: string;

  homeAddress: string;

  token?: string;
}
