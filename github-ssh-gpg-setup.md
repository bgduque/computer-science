# GitHub SSH and GPG Setup Guide

This guide walks you through setting up SSH keys (RSA and ed25519) and GPG keys for GitHub.

## Table of Contents
- [SSH Key Setup](#ssh-key-setup)
  - [Generate SSH Keys (RSA)](#generate-ssh-keys-rsa)
  - [Generate SSH Keys (ed25519)](#generate-ssh-keys-ed25519)
  - [Add SSH Key to ssh-agent](#add-ssh-key-to-ssh-agent)
  - [Add SSH Key to GitHub](#add-ssh-key-to-github)
  - [Test SSH Connection](#test-ssh-connection)
- [SSH Signing Key Setup (Alternative to GPG)](#ssh-signing-key-setup-alternative-to-gpg)
  - [Generate SSH Signing Key (RSA)](#generate-ssh-signing-key-rsa)
  - [Add SSH Signing Key to GitHub](#add-ssh-signing-key-to-github)
  - [Configure Git to Use SSH Signing](#configure-git-to-use-ssh-signing)
  - [Sign Commits with SSH](#sign-commits-with-ssh)
- [GPG Key Setup](#gpg-key-setup)
  - [Generate GPG Key](#generate-gpg-key)
  - [Add GPG Key to GitHub](#add-gpg-key-to-github)
  - [Configure Git to Use GPG](#configure-git-to-use-gpg)
  - [Sign Commits](#sign-commits)

---

## SSH Key Setup

### Generate SSH Keys (RSA)

1. Open your terminal

2. Generate an RSA SSH key (4096-bit for enhanced security):
   ```bash
   ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
   ```

3. When prompted for a file location, press **Enter** to accept the default (`~/.ssh/id_rsa`) or specify a custom path:
   ```
   Enter file in which to save the key (/Users/you/.ssh/id_rsa): [Press enter]
   ```

4. Enter a secure passphrase when prompted (recommended):
   ```
   Enter passphrase (empty for no passphrase): [Type a passphrase]
   Enter same passphrase again: [Type passphrase again]
   ```

### Generate SSH Keys (ed25519)

1. Generate an ed25519 SSH key (modern, more secure algorithm):
   ```bash
   ssh-keygen -t ed25519 -C "your_email@example.com"
   ```

2. When prompted for a file location, press **Enter** to accept the default (`~/.ssh/id_ed25519`) or specify a custom path:
   ```
   Enter file in which to save the key (/Users/you/.ssh/id_ed25519): [Press enter]
   ```

3. Enter a secure passphrase when prompted:
   ```
   Enter passphrase (empty for no passphrase): [Type a passphrase]
   Enter same passphrase again: [Type passphrase again]
   ```

> [!NOTE]
> ed25519 is generally recommended over RSA as it's faster, more secure, and generates shorter keys. However, some legacy systems may not support it.

### Add SSH Key to ssh-agent

1. Start the ssh-agent in the background:
   ```bash
   eval "$(ssh-agent -s)"
   ```

2. **For macOS users**, modify your `~/.ssh/config` file to automatically load keys:
   ```bash
   touch ~/.ssh/config
   ```
   
   Add the following to `~/.ssh/config`:
   ```
   Host github.com
     AddKeysToAgent yes
     UseKeychain yes
     IdentityFile ~/.ssh/id_ed25519
     IdentityFile ~/.ssh/id_rsa
   ```

3. Add your SSH private key to the ssh-agent:
   
   For ed25519:
   ```bash
   ssh-add --apple-use-keychain ~/.ssh/id_ed25519
   ```
   
   For RSA:
   ```bash
   ssh-add --apple-use-keychain ~/.ssh/id_rsa
   ```
   
   > [!TIP]
   > On Linux, omit the `--apple-use-keychain` flag and use `ssh-add ~/.ssh/id_ed25519` instead.

### Add SSH Key to GitHub

1. Copy the SSH public key to your clipboard:
   
   For ed25519:
   ```bash
   pbcopy < ~/.ssh/id_ed25519.pub
   ```
   
   For RSA:
   ```bash
   pbcopy < ~/.ssh/id_rsa.pub
   ```
   
   > [!TIP]
   > On Linux, use `xclip` or `cat ~/.ssh/id_ed25519.pub` to display and manually copy.

2. Go to [GitHub SSH Settings](https://github.com/settings/keys)

3. Click **New SSH key** or **Add SSH key**

4. In the "Title" field, add a descriptive label (e.g., "Personal MacBook Pro - ed25519")

5. Select **Authentication Key** as the key type

6. Paste your key into the "Key" field

7. Click **Add SSH key**

8. If prompted, confirm access with your GitHub password

### Test SSH Connection

Verify your SSH connection to GitHub:

```bash
ssh -T git@github.com
```

You should see a message like:
```
Hi username! You've successfully authenticated, but GitHub does not provide shell access.
```

---

## SSH Signing Key Setup (Alternative to GPG)

GitHub supports using SSH keys to sign commits as a simpler alternative to GPG. This section shows how to set up an RSA SSH signing key.

> [!NOTE]
> SSH signing is a newer feature that's easier to set up than GPG. You can use either SSH or GPG signing, but not both simultaneously.

### Generate SSH Signing Key (RSA)

You can use your existing RSA authentication key for signing, or generate a dedicated signing key.

**Option 1: Use Existing RSA Key**
If you already generated an RSA key for authentication, you can use the same key for signing. Skip to [Add SSH Signing Key to GitHub](#add-ssh-signing-key-to-github).

**Option 2: Generate Dedicated RSA Signing Key**

1. Generate a new RSA key specifically for signing:
   ```bash
   ssh-keygen -t rsa -b 4096 -C "your_email@example.com" -f ~/.ssh/id_rsa_signing
   ```

2. When prompted for a passphrase, enter a secure passphrase (recommended):
   ```
   Enter passphrase (empty for no passphrase): [Type a passphrase]
   Enter same passphrase again: [Type passphrase again]
   ```

3. Add the signing key to ssh-agent:
   ```bash
   eval "$(ssh-agent -s)"
   ssh-add --apple-use-keychain ~/.ssh/id_rsa_signing
   ```
   
   > [!TIP]
   > On Linux, omit `--apple-use-keychain` and use `ssh-add ~/.ssh/id_rsa_signing`

### Add SSH Signing Key to GitHub

1. Copy your SSH public key to clipboard:
   
   If using existing RSA key:
   ```bash
   pbcopy < ~/.ssh/id_rsa.pub
   ```
   
   If using dedicated signing key:
   ```bash
   pbcopy < ~/.ssh/id_rsa_signing.pub
   ```
   
   > [!TIP]
   > On Linux, use `cat ~/.ssh/id_rsa_signing.pub` to display and manually copy

2. Go to [GitHub SSH Settings](https://github.com/settings/keys)

3. Click **New SSH key**

4. In the "Title" field, add a descriptive label (e.g., "Personal MacBook Pro - RSA Signing Key")

5. Select **Signing Key** as the key type (this is different from Authentication Key!)

6. Paste your public key into the "Key" field

7. Click **Add SSH key**

8. If prompted, confirm access with your GitHub password

> [!IMPORTANT]
> Make sure to select **Signing Key** as the type, not Authentication Key. You can add the same key twice with different types if you want to use it for both authentication and signing.

### Configure Git to Use SSH Signing

1. Tell Git to use SSH for signing commits:
   ```bash
   git config --global gpg.format ssh
   ```

2. Specify which SSH key to use for signing:
   
   If using existing RSA key:
   ```bash
   git config --global user.signingkey ~/.ssh/id_rsa.pub
   ```
   
   If using dedicated signing key:
   ```bash
   git config --global user.signingkey ~/.ssh/id_rsa_signing.pub
   ```

3. Configure Git to sign all commits by default (optional but recommended):
   ```bash
   git config --global commit.gpgsign true
   ```

4. Configure Git to sign all tags by default (optional):
   ```bash
   git config --global tag.gpgsign true
   ```

5. Set your Git email and name if not already configured:
   ```bash
   git config --global user.email "your_email@example.com"
   git config --global user.name "Your Name"
   ```

### Sign Commits with SSH

Now your commits will be automatically signed if you configured `commit.gpgsign true`. Otherwise, sign commits manually:

```bash
git commit -S -m "Your commit message"
```

To sign a tag:
```bash
git tag -s v1.0.0 -m "Version 1.0.0"
```

To verify a signed commit:
```bash
git log --show-signature
```

Or verify the last commit:
```bash
git verify-commit HEAD
```

You should see your commits marked as "Verified" on GitHub!

---

## GPG Key Setup

### Generate GPG Key

1. Check if GPG is installed:
   ```bash
   gpg --version
   ```
   
   If not installed, install it:
   - **macOS**: `brew install gnupg`
   - **Linux (Ubuntu/Debian)**: `sudo apt-get install gnupg`
   - **Linux (Fedora)**: `sudo dnf install gnupg`

2. Generate a new GPG key:
   ```bash
   gpg --full-generate-key
   ```

3. At the prompt, select the key type:
   - Select `(1) RSA and RSA` (default is fine)
   - Press **Enter**

4. Enter the desired key size (at least 4096 bits):
   ```
   What keysize do you want? (3072) 4096
   ```

5. Specify how long the key should be valid:
   ```
   Key is valid for? (0) 0
   ```
   `0` means the key does not expire (or specify `1y` for 1 year, etc.)

6. Verify your selections and confirm

7. Enter your user information:
   - **Real name**: Your full name
   - **Email address**: The email associated with your GitHub account
   - **Comment**: Optional description

8. Confirm your information with `O` (Okay)

9. Enter a secure passphrase for your GPG key

### Add GPG Key to GitHub

1. List your GPG keys:
   ```bash
   gpg --list-secret-keys --keyid-format=long
   ```
   
   Output will look like:
   ```
   /Users/you/.gnupg/secring.gpg
   ------------------------------------
   sec   rsa4096/3AA5C34371567BD2 2024-01-01 [SC]
   uid                 [ultimate] Your Name <your_email@example.com>
   ssb   rsa4096/4BB6D45482678BE3 2024-01-01 [E]
   ```

2. Copy the GPG key ID (the part after `rsa4096/`). In the example above, it's `3AA5C34371567BD2`

3. Export your GPG public key:
   ```bash
   gpg --armor --export 3AA5C34371567BD2
   ```
   
   This will print your GPG key in ASCII armor format. Copy the entire output, including:
   ```
   -----BEGIN PGP PUBLIC KEY BLOCK-----
   ...
   -----END PGP PUBLIC KEY BLOCK-----
   ```

4. Go to [GitHub GPG Settings](https://github.com/settings/keys)

5. Click **New GPG key**

6. Paste your GPG key into the "Key" field

7. Click **Add GPG key**

8. If prompted, confirm access with your GitHub password

### Configure Git to Use GPG

1. Tell Git about your GPG key (use your key ID):
   ```bash
   git config --global user.signingkey 3AA5C34371567BD2
   ```

2. Configure Git to sign all commits by default (optional but recommended):
   ```bash
   git config --global commit.gpgsign true
   ```

3. Configure Git to sign all tags by default (optional):
   ```bash
   git config --global tag.gpgsign true
   ```

4. Set your Git email to match your GPG key email:
   ```bash
   git config --global user.email "your_email@example.com"
   ```

5. Set your Git name to match your GPG key name:
   ```bash
   git config --global user.name "Your Name"
   ```

6. **For macOS users**, configure GPG to use the correct TTY:
   ```bash
   echo 'export GPG_TTY=$(tty)' >> ~/.zshrc
   source ~/.zshrc
   ```
   
   > [!TIP]
   > If using bash, replace `~/.zshrc` with `~/.bashrc`

### Sign Commits

Now your commits will be automatically signed if you configured `commit.gpgsign true`. Otherwise, sign commits manually:

```bash
git commit -S -m "Your commit message"
```

To sign a tag:
```bash
git tag -s v1.0.0 -m "Version 1.0.0"
```

To verify a signed commit:
```bash
git log --show-signature
```

Or verify the last commit:
```bash
git verify-commit HEAD
```

---

## Verification

### Check SSH Setup
```bash
ssh -T git@github.com
```

### Check SSH Signing Setup
```bash
git config --global gpg.format
git config --global user.signingkey
```

Should show `ssh` and your public key path respectively.

### Check GPG Setup
```bash
git log --show-signature -1
```

You should see "Good signature" and a "Verified" badge on your commits in GitHub.

---

## Troubleshooting

### GPG Passphrase Prompts

If you're getting repeated passphrase prompts, configure GPG agent:

1. Edit or create `~/.gnupg/gpg-agent.conf`:
   ```bash
   echo "default-cache-ttl 3600" >> ~/.gnupg/gpg-agent.conf
   echo "max-cache-ttl 86400" >> ~/.gnupg/gpg-agent.conf
   ```

2. Reload the GPG agent:
   ```bash
   gpgconf --kill gpg-agent
   ```

### SSH Permission Denied

If you get "Permission denied (publickey)":
1. Verify your SSH key is added to ssh-agent: `ssh-add -l`
2. Verify the key is added to GitHub
3. Check your SSH config file (`~/.ssh/config`)

---

## Summary

You now have:
- ✅ RSA SSH key generated and added to GitHub
- ✅ ed25519 SSH key generated and added to GitHub  
- ✅ RSA SSH signing key generated and added to GitHub (alternative to GPG)
- ✅ GPG key generated and added to GitHub
- ✅ Git configured to sign commits (using either SSH or GPG)

All your commits will now be verified and your SSH connections to GitHub will be authenticated!
