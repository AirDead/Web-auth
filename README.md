## Minecraft Web Auth System

### Overview
This project links a Google/Discord and other account to a specific UUID on a Minecraft server.
Making server safe from bots. 1 account per 1 account(Google, Discord or other)
After successful authentication, the player's account is bound to their unique Minecraft UUID, ensuring access only for authorized players.

### Key Features:
1. Players receive a link for Discord authentication.
2. After successful authentication, the Discord account is linked to the player's UUID.
3. Only the bound account can use the corresponding nickname on the server.

### Tech Stack:
- Minecraft server: Paperweight 1.20.1
- Backend: Ktor
- Auth: Now only Discord, soon maybe other apps like telegram.

### TODO

1. **Create Backend**:
   - Handle authentication logic.
   - Side tasks:
      - Refactor logic to prevent bypassing authorization.
      - Make the system abstract to allow other authentication methods beyond Discord.

2. **Bind to Minecraft Account**:
   - Add binding to the Minecraft UUID for uniqueness.

3. **Documentation**:
   - Provide clear setup instructions and describe the process of linking Discord accounts to Minecraft nicknames (UUID).