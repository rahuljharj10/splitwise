# Splitwise 2040 — Product Roadmap

> The vision: build the **last expense-sharing app anyone will ever need**.
> A modern, AI-native, privacy-first, payments-integrated, future-proof platform.

**Tech baseline:** Spring Boot (Java) + Gradle, PostgreSQL, Redis, Kafka, React/Flutter clients.

---

## 🎯 Vision & Guiding Principles

1. **Frictionless** — splitting an expense should take < 3 seconds (or zero, via AI).
2. **AI-native** — every flow has an agentic shortcut (voice, NL, vision).
3. **Privacy-first** — end-to-end encryption, zero-knowledge where possible.
4. **Money moves, not just IOUs** — real settlement via UPI / SEPA / stablecoins built-in.
5. **Open & portable** — open API, data export, self-host option. No lock-in.
6. **Future-proof** — quantum-resistant crypto, plugin architecture, spec-driven.

---

## 🏛️ 1. Core Foundation (Table Stakes)

- [ ] Groups & nested sub-groups (trip → day → meal)
- [ ] Split types: equal, exact, percentage, shares, adjustments, itemized
- [ ] Multi-currency with real-time FX + historical rate locking
- [ ] Debt simplification (min-cost flow graph algorithm)
- [ ] Recurring expenses (rent, subscriptions, EMIs)
- [ ] Offline-first sync with CRDT-based conflict resolution
- [ ] Activity feed, comments, reactions, attachments
- [ ] Export: PDF, CSV, Excel, Tally, QuickBooks, Zoho

---

## 🤖 2. AI / Agentic Features (2040 Core)

| Feature | Description |
|---|---|
| **AI Expense Agent** | Voice/NL: "Split last night's dinner with Rahul and Priya, I paid." |
| **Receipt Vision AI** | Snap bill → extract items, tax, tip; assign items per person via face/name. |
| **Predictive Splits** | Learns habits ("Rahul never eats dessert") and auto-excludes. |
| **Auto-categorization & Budgeting** | LLM tags every expense, forecasts month-end. |
| **Natural Language Queries** | "How much did I spend on Goa vs Manali?" |
| **Fraud / Duplicate Detection** | Flags double-entered or suspicious expenses. |
| **Smart Reminders** | Nudges at optimal time (e.g., post-salary credit). |
| **Negotiation Agent** | Users' agents auto-settle disputes / propose fair splits. |

---

## 💸 3. Payments & Settlement

- [ ] One-tap settle: UPI, SEPA, ACH, PIX, FedNow, Wise, PayPal, Venmo, Cash App
- [ ] In-app wallet with instant P2P transfer
- [ ] Stablecoin & CBDC support (USDC, e₹, digital euro) for zero-fee cross-border
- [ ] Auto-settle thresholds ("settle when I owe > ₹500")
- [ ] Group escrow / prepaid trip wallet
- [ ] BNPL integration ("buy-now-split-later")
- [ ] GST/VAT-compliant tax receipts for business expenses

---

## 🔗 4. Web3 / Decentralized Layer (Optional)

- [ ] Self-sovereign identity (DID) — ledger not locked to one company
- [ ] On-chain group ledger with zk-proof privacy
- [ ] Smart-contract escrow for roommates / business partners
- [ ] NFT trip memories (photos + expense summary)

---

## 🌐 5. Integrations & Ecosystem

- [ ] Bank/UPI auto-import (Account Aggregator / Plaid / TrueLayer)
- [ ] Calendar sync (Google / Outlook) — events auto-create groups
- [ ] Travel apps (MakeMyTrip, Booking, Uber, Ola) — pull receipts
- [ ] Food delivery (Swiggy, Zomato, DoorDash) — auto-split orders
- [ ] Smart home: Alexa / Google / Siri quick-add
- [ ] Wearables: Apple Watch / Pixel Watch
- [ ] Browser extension — split any online purchase
- [ ] Public REST API + Webhooks + **MCP server** for AI agents

---

## 🥽 6. Immersive & Spatial (2030+)

- [ ] AR receipt scanning (Vision Pro / smart glasses)
- [ ] Spatial 3D debt-network view
- [ ] Voice-first hands-free mode (driving)
- [ ] Haptic confirmations on wearables

---

## 🔐 7. Privacy, Security & Trust

- [ ] End-to-end encryption (zero-knowledge server)
- [ ] Biometric + passkey auth (no passwords)
- [ ] Granular sharing (share balance only, not history)
- [ ] GDPR / DPDP one-click export & delete
- [ ] Tamper-evident audit log (hash chain)
- [ ] Quantum-resistant crypto (Kyber / Dilithium)

---

## 👥 8. Social & Collaboration

- [ ] Built-in group chat (no WhatsApp side-channel needed)
- [ ] Polls ("Who's in for dinner Saturday?")
- [ ] Trip planner — itinerary + budget + expenses unified
- [ ] Modes: Couple / Family / Roommate / Business
- [ ] Kids/teen accounts with parental controls (allowance, chores)
- [ ] Business mode: approval workflows, reimbursements, policies

---

## 📊 9. Insights & Wellness

- [ ] Financial wellness score (per group/person)
- [ ] Spending personality (foodie, traveler, saver)
- [ ] Carbon footprint per expense
- [ ] Year-in-review (Spotify-Wrapped-style reel)
- [ ] Goal tracking ("Save ₹50k for Japan trip")

---

## ♿ 10. Accessibility & Global Reach

- [ ] 40+ languages with on-device translation
- [ ] Screen-reader, high-contrast, dyslexia-friendly fonts
- [ ] Low-bandwidth mode (2G-friendly)
- [ ] SMS / USSD fallback for feature phones
- [ ] Regional compliance: GST (IN), VAT (EU), 1099-K (US), PSD3, RBI

---

## 🧩 11. Extensibility

- [ ] Plugin marketplace (third-party modules: crypto tax, freelance invoicing…)
- [ ] Workflow builder (Zapier/n8n-style automations)
- [ ] Self-host Docker image (privacy / enterprise)
- [ ] Open data-portability schema

---

## 🚀 Phased Delivery Plan

### Phase 1 — MVP (Months 0–3)
- Core domain: `User`, `Group`, `Expense`, `Split`, `Settlement`, `Currency`
- Equal / exact / percentage splits
- Debt simplification service
- UPI settle (India-first)
- JWT + passkey-ready auth
- Basic AI auto-categorization
- REST API + OpenAPI docs
- PostgreSQL + Flyway migrations

### Phase 2 — Smart & Connected (Months 3–9)
- Receipt OCR + Vision AI
- Recurring expenses
- Multi-currency + FX
- Bank/UPI auto-import
- Built-in group chat
- Mobile apps (Flutter)

### Phase 3 — Agentic & Financial (Months 9–18)
- Full AI Expense Agent (voice + NL)
- In-app wallet + escrow
- Stablecoin / CBDC rails
- Integrations marketplace
- MCP server for third-party AI agents
- Business mode

### Phase 4 — Future-Proof (Months 18+)
- AR / spatial UX (Vision Pro, smart glasses)
- Web3 optional ledger + DID
- Quantum-resistant cryptography
- Plugin SDK + marketplace
- Self-host distribution

---

## 📐 Success Metrics

- **Time to log an expense:** < 3 seconds (target: 0s via AI)
- **Settlement rate:** > 80% of debts settled in-app within 7 days
- **Retention (D30):** > 50%
- **NPS:** > 60
- **API ecosystem:** 100+ third-party integrations by Phase 4

---

## 🛠️ Suggested Tech Stack

| Layer | Choice |
|---|---|
| Backend | Spring Boot 3.x (Java 21), Gradle |
| DB | PostgreSQL 16 + Flyway |
| Cache / Queue | Redis, Kafka |
| Search | OpenSearch |
| AI | OpenAI / Anthropic / on-device Llama for privacy mode |
| Auth | Spring Security + WebAuthn (passkeys) |
| Mobile | Flutter (iOS + Android + Web) |
| Web | React + Vite + Tailwind |
| Infra | Kubernetes, Terraform, GitHub Actions |
| Observability | OpenTelemetry, Grafana, Loki |

---

*Last updated: June 2026 — living document.*

