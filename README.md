# ByteBites - Fly.io Deployment Guide

This repository contains:
- `backend-spring boot`: Spring Boot API (Java 17 + MySQL)
- `frontend-react`: React frontend

This guide helps you run the app as a **containerized full-stack deployment on Fly.io** with:
- Cloud-managed MySQL
- Environment-based configuration
- CI/CD through GitHub Actions

---

## 1) Prerequisites

Install these tools on your machine:

1. [Fly CLI (`flyctl`)](https://fly.io/docs/hands-on/install-flyctl/)
2. Docker
3. GitHub repository access (admin/write)
4. A MySQL database (recommendation: Fly Managed MySQL or external managed MySQL)

Then login:

```bash
fly auth login
```

---

## 2) What was added to this repo

- `backend-spring boot/Dockerfile`
- `frontend-react/Dockerfile`
- `deploy/fly.backend.toml`
- `deploy/fly.frontend.toml`
- `.github/workflows/fly-deploy.yml`

Also updated for environment-based config:
- Backend DB, mail, Stripe, CORS, frontend URL are configurable via env vars.
- Frontend API URL now uses `REACT_APP_API_URL`.

---

## 3) Create Fly apps (one for API, one for frontend)

```bash
fly apps create bytebites-api
fly apps create bytebites-web
```

If names are taken, use your own names and update them in:
- `deploy/fly.backend.toml`
- `deploy/fly.frontend.toml`

---

## 4) Prepare MySQL connection

Use a managed MySQL provider and get the connection URL in this format:

```text
jdbc:mysql://<host>:3306/<database>?createDatabaseIfNotExist=true&useSSL=true
```

Set backend secrets on Fly:

```bash
fly secrets set \
  SPRING_DATASOURCE_URL="jdbc:mysql://<host>:3306/bytebites?createDatabaseIfNotExist=true&useSSL=true" \
  SPRING_DATASOURCE_USERNAME="<db_user>" \
  SPRING_DATASOURCE_PASSWORD="<db_password>" \
  APP_FRONTEND_URL="https://bytebites-web.fly.dev" \
  APP_CORS_ALLOWED_ORIGINS="https://bytebites-web.fly.dev,http://localhost:3000" \
  STRIPE_API_KEY="<stripe_key>" \
  SPRING_MAIL_USERNAME="<smtp_user>" \
  SPRING_MAIL_PASSWORD="<smtp_password>" \
  -a bytebites-api
```

> Note: Keep `APP_FRONTEND_URL` and `APP_CORS_ALLOWED_ORIGINS` synced with your real frontend domain.

---

## 5) First manual deployment

Deploy backend:

```bash
fly deploy -c deploy/fly.backend.toml
```

Deploy frontend:

```bash
fly deploy -c deploy/fly.frontend.toml
```

Open apps:

```bash
fly open -a bytebites-api
fly open -a bytebites-web
```

---

## 6) CI/CD setup (GitHub Actions)

Workflow file: `.github/workflows/fly-deploy.yml`

On every push to `main`:
1. Deploy backend
2. Deploy frontend

### Add required GitHub secret
In your GitHub repo: `Settings -> Secrets and variables -> Actions`

Create secret:
- `FLY_API_TOKEN`

Generate token:

```bash
fly tokens create deploy
```

Paste output token into `FLY_API_TOKEN`.

---

## 7) Environment variables used by the app

### Backend (`bytebites-api`)
- `PORT` (default `5454`)
- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- `SPRING_JPA_HIBERNATE_DDL_AUTO` (default `update`)
- `SPRING_JPA_SHOW_SQL` (default `true`)
- `APP_FRONTEND_URL` (password reset link base URL)
- `APP_CORS_ALLOWED_ORIGINS` (comma-separated)
- `STRIPE_API_KEY`
- `SPRING_MAIL_HOST` (default `smtp.gmail.com`)
- `SPRING_MAIL_PORT` (default `587`)
- `SPRING_MAIL_USERNAME`
- `SPRING_MAIL_PASSWORD`

### Frontend (`bytebites-web`)
- Build arg: `REACT_APP_API_URL`

Update API endpoint by changing `deploy/fly.frontend.toml` -> `build.args.REACT_APP_API_URL` and redeploy.

---

## 8) Verify deployment health

```bash
fly status -a bytebites-api
fly logs -a bytebites-api
fly status -a bytebites-web
fly logs -a bytebites-web
```

Quick API check:

```bash
curl -I https://bytebites-api.fly.dev
```

---

## 9) Common troubleshooting

1. **Frontend cannot call backend (CORS)**
   - Ensure backend secret `APP_CORS_ALLOWED_ORIGINS` includes exact frontend URL.

2. **Database connection failure**
   - Validate `SPRING_DATASOURCE_URL`, user, password.
   - Check provider firewall/network allowlist for Fly outbound traffic.

3. **Password reset URL wrong**
   - Set `APP_FRONTEND_URL` to your frontend Fly domain.

4. **CI deploy fails with auth error**
   - Recreate and update `FLY_API_TOKEN` in GitHub secrets.

---

## 10) Recommended next hardening steps

- Move `spring.jpa.hibernate.ddl-auto` from `update` to `validate` for production.
- Add `/actuator/health` endpoint and Fly health checks.
- Set custom domains + TLS on both Fly apps.
- Add staging apps (e.g., `bytebites-api-staging`, `bytebites-web-staging`) and separate workflows.

---

If you want, I can next help you with a **custom domain setup** and a **staging/production split** in Fly.io.
