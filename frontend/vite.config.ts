import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/api': {
       // target: 'localhost:8080'
         target: 'http://localhost:8080'
       // target: 'https://irregularverbspracticeapp.onrender.com'
      }
    }
  }
})