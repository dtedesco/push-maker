# push-maker
PushNotification para Maker-Softwell

### Descrição
Esta é uma biblioteca de Notificação para iOS e Android compilada para a plataforma Maker Softwell

### Requisitos
Maker 2.6 ou superior <br>
Java 1.6 ou superior
### Instalação
<pre><code>Importar o arquivo "FUNÇÃO - Push Notification 1.0.FRZ" na ferramenta</code></pre>
<pre><code>Copiar o arquivo "push.jar" para a pasta "WEB-INF\lib"</code></pre>
### Configuração
<pre><code>Para Android: Cadastrar no Google GCM obter o Sender ID e alterar no código da função
Tutorial: http://dev.tapjoy.com/faq/how-to-find-sender-id-and-api-key-for-gcm/</code></pre>

<pre><code>Para IOS: Gerar o certificado e colocar na pasta WEB-INF dentro do contexto e alterar a senha do certificado no código da Função
Tutorial: http://quickblox.com/developers/How_to_create_APNS_certificates</code></pre>

###Uso
Parâmetros:
1. Plataforma; (Android ou iOS)
2. Token; (Gerado pelo Celular)
3. Título do push;
4. Mensagem do Push;
5. Contador de Mensagens;
6. Info; (Json com outros dados)

Exemplos: 
1º Parâmetro: Android
2º Parâmetro: APA91bEVfyJGil8SxAJ8gEBvNPyf2shWxH9ju76zPS0EmEA5vBF1QuoM6kuVozPUbQBua1AdvHaX0Izbfi1UD_eij0
3º Parâmetro: Exemplo Teste
4º Parâmetro: Exemplo de push via maker
5º Parâmetro: 3
6º Parâmetro: {"token":"123","sistema":"Maker"}

Retorno: Verdadeiro se o arquivo foi gerado

Retorno: 
Esta função retorna true se sucesso e false se erro.

###Observações
1. O parâmetro 1 deve ser criado um id na Google: https://support.google.com/googleplay/android-developer/answer/2663268?hl=pt-BR.
2. As configurações de cadas serviço está dentro da função
3. A configuração do ID da Google e do Certificado da Apple estão dentro da função.
4. A função requer o arquivo push.jar

Versão: 1.0.0.0
