export interface Response {
  status: number
  message: string
  payload: any | any[]
}

export interface Movie {
  id: number
  title: string
  synopsys: string
  releaseYear: string
}

export interface Person {
  id: number | string
  name: string
  middle_name?: string | null
  surname: string
  bDate: string
  category: Category
}

export enum Category {
  director,
  actor
}