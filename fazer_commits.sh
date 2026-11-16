#!/usr/bin/env bash
# Rode na raiz do repositório clonado (crud-spring-livros), já logado no GitHub.
set -e

echo ">> Checkpoint 1"
git add pom.xml .gitignore src/main/java/br/umc/livros/LivrosApplication.java \
  src/test src/main/resources/application.properties \
  src/main/java/br/umc/livros/model src/main/java/br/umc/livros/repository
git commit -m "feat: configura projeto, entidade Livro e repository"
git push origin main
read -p "Rode a aplicação, confira a tabela 'livro' no phpMyAdmin e pressione ENTER..."

echo ">> Checkpoint 2"
git add src/main/java/br/umc/livros/service src/main/java/br/umc/livros/controller
git commit -m "feat: implementa LivroService e rotas CRUD no Controller"
git push origin main
read -p "Reinicie a aplicação (sem erros de compilação) e pressione ENTER..."

echo ">> Checkpoint 3"
git add .
git commit -m "feat: adiciona telas thymeleaf, validacao e css"
git push origin main
echo "Pronto! Agora faça o Passo 5 (3 livros + prints)."
