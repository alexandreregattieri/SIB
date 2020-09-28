# SIB

Projeto de geração de arquivos SIB com dados obtidos através de XLS, seguindo o padrão estabelecido pela ANS.

Este projeto foi criado para atender uma demanda das Operadoras de Plano de Saúde CESAN (Registo ANS nº 39.240-5), tendo seu início no ano de 2016.

Observações:

Foram omitidos os dados das consultas ou dados de informação da Operadora, por uma questão de segurança e de tratar-se de uma produção específica para cada situação;

A classe "Principal" localizada no pacote "principal" inicializa o programa de geração do arquivo SIB (SBX);

Na classe "Principal", a variável "cam" deve ser preenchida com o local onde encontra-se o arquivo XLS;

Na classe "Principal", o diretório armazenado na variável "cam" será o mesmo que será salvo o arquivo SIB.
